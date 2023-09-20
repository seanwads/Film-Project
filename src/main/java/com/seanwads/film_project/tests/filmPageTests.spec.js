const { test, expect } = require('@playwright/test');

test('page load', async ({ page }) => {
    await page.goto('http://localhost:3000/');

    // Expect page to contain page heading - thus, page has loaded
    await expect(page.getByText('Totally Real And Not Auto-Generated Movies')).toBeVisible();
});

test('fetch films', async ({ page }) => {
    await page.goto('http://localhost:3000/');

    //Assert page contains first film card of list of films
    await expect(page.getByTestId('film-card-1')).toBeVisible();
    await expect(page.getByText('ABSOLUTE DINOSAUR')).toBeVisible();

    //Assert page contains correct number of elements
    await expect(page.locator('.card')).toHaveCount(1001);
        
})

test('filter films', async({ page }) => {
    await page.goto('http://localhost:3000/');

    //Select 'Action' category filter
    await page.getByRole('button', {name:'Action'}).click();

    //Assert that page does not contain first film card - thus films have been filtered
    await expect(page.getByTestId('film-card-1')).toBeHidden();
    await expect(page.getByText('ABSOLUTE DINOSAUR')).toBeHidden();

    //Select 'All' category filter
    await page.getByRole('button', {name:'All'}).click();

    //Assert page contains first film card of list of films
    await expect(page.getByTestId('film-card-1')).toBeVisible();
    await expect(page.getByText('ABSOLUTE DINOSAUR')).toBeVisible();

    //Assert page contains correct number of elements
    await expect(page.locator('.card')).toHaveCount(1001);
})

test('edit film', async({ page }) => {
    await page.goto('http://localhost:3000/');

    //Assert that update menu is not open on load
    await expect(page.getByRole('textbox')).toBeHidden();

    //Open update menu for first film in list
    await page
        .getByTestId('film-card-1')
        .getByRole('button', {name:'Update'})
        .click(); 
    
    //Fill update input field and submit
    await page.getByRole('textbox').fill('TEST_PLACEHOLDER');
    await page.getByRole('button', {name:'Submit'}).click();

    //Assert that film has been edited and page has been updated
    await expect(page.getByText('TEST_PLACEHOLDER')).toBeVisible();

    //Open update menu for first film in list
    await page
        .getByTestId('film-card-1')
        .getByRole('button', {name:'Update'})
        .click(); 
    
    //Reset film name to original
    await page.getByRole('textbox').fill('ABSOLUTE DINOSAUR');
    await page.getByRole('button', {name:'Submit'}).click();
})
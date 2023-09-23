package com.seanwads.film_project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void setId() {
        Actor actor = new Actor();
        actor.setId(1);
        assertEquals(actor.getId(), 1);
    }
}
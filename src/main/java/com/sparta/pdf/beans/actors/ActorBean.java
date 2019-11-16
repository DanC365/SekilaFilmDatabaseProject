package com.sparta.pdf.beans.actors;

import com.sparta.pdf.components.Actor;
import com.sparta.pdf.services.FilmActorRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ActorBean {

    private Actor activeActor;

    @Inject
    FilmActorRetriever filmActorRetriever;

    public String setActiveActor(Actor actor){
        activeActor = actor;
        return "actorDetails";
    }

    public Actor getActiveActor() {
        return activeActor;
    }



}

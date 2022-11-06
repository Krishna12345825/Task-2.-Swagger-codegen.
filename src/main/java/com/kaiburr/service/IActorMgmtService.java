//IActorMgmtService.java

package com.kaiburr.service;

import java.util.List;
import com.kaiburr.document.Actor;

public interface IActorMgmtService {

	public String registerActor(Actor actor);

	public Iterable<Actor> getAllActors();

	public Actor getActorById(String id);

	public List<Actor> fetchActorsByCategory(String category1, String category2);

	public String updateActor(Actor actor);

	public String deleteActorById(String id);

	public String updateActorMobileNo(String id, long newMobileNo);

}

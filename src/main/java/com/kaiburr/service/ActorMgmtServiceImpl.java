package com.kaiburr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiburr.document.Actor;
import com.kaiburr.exception.ActorNotFoundException;
import com.kaiburr.repository.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepo actorRepo;

	@Override
	public String registerActor(Actor actor) {
		Actor actorS = actorRepo.save(actor);
		return "Actor is registered with id value ::" + actorS.getId();
	}

	@Override
	public Iterable<Actor> getAllActors() {
		Iterable<Actor> it = actorRepo.findAll();
		List<Actor> list1 = StreamSupport.stream(it.spliterator(), false)
				.sorted((t1, t2) -> t1.getActorname().compareTo(t2.getActorname())).collect(Collectors.toList());
		return list1;
	}

	@Override
	public Actor getActorById(String id) {
		return actorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid  actor id"));
	}

	@Override
	public List<Actor> fetchActorsByCategory(String category1, String category2) {
		List<Actor> list = actorRepo.getActorsByCategories(category1, category2);
		return list;
	}

	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt = actorRepo.findById(actor.getId());
		if (opt.isPresent()) {
			actorRepo.save(actor); // update object
			return "Actor Information is updated";
		} else {
			throw new ActorNotFoundException("Actor not found");
		}
	}

	@Override
	public String deleteActorById(String id) {
		Optional<Actor> opt = actorRepo.findById(id);
		if (opt.isPresent()) {
			actorRepo.deleteById(id);
			return "Actor Information is deleted";
		} else {
			throw new ActorNotFoundException("Actor not found");
		}
	}

	@Override
	public String updateActorMobileNo(String id, long newMobileNo) {
		Optional<Actor> opt = actorRepo.findById(id);
		if (opt.isPresent()) {
			Actor actor = opt.get();
			actor.setMobileNo(newMobileNo);
			actorRepo.save(actor); // update object
			return "Actor's Mobile Number is  updated";
		} else {
			throw new ActorNotFoundException("Actor not found");
		}

	}

}
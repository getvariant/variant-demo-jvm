package com.variant.demo;

import org.springframework.samples.petclinic.owner.Owner;

import java.util.Set;

public class OwnerWrapper {

	public final long dogOrCatCount;

	public final Owner owner;

	private boolean isVaccinationScheduled = false;

	public OwnerWrapper(Owner owner) {
		this.owner = owner;
		dogOrCatCount = owner.getPets().stream().filter(pet -> Set.of(1, 2).contains(pet.getType().getId())).count();
	}

	public void scheduleVaccination() {
		isVaccinationScheduled = true;
	}

	public Boolean isVaccinationScheduled() {
		return isVaccinationScheduled;
	}

}

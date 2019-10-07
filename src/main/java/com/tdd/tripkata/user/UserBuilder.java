package com.tdd.tripkata.user;

import com.tdd.tripkata.trip.Trip;

public class UserBuilder{
	private User[] friends;
	private Trip[] trips;

	public static UserBuilder aUser() {
		return new UserBuilder();
	}

	public UserBuilder friendsWith(User... users) {
		this.friends = users; 
		return this;
	}
	
	public UserBuilder hasTripsTo(Trip... trips) {
		this.trips = trips; 
		return this;
	}
	
	public User build() {
		User user = new User();
		addFriendsToUser(user);
		addTripsToUser(user);
		return user;
	}

	private void addTripsToUser(User user) {
		for (Trip trip : this.trips) {
			user.addTrip(trip);
		}
	}

	private void addFriendsToUser(User user) {
		for (User u : this.friends) {
			user.addFriend(u);				
		}
	}
}
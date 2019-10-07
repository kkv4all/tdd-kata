package com.tdd.tripkata.trip;

import java.util.ArrayList;
import java.util.List;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;

public class TripService {

	TripDAO tripDAO;
	
	public TripService(TripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}

	private static final ArrayList<Trip> NO_TRIP = new ArrayList<Trip>();

	public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
		validateUser(loggedUser);

		return (user.isFriendsWith(loggedUser)) ?tripsBy(user):
			NO_TRIP;
	}
	
	protected void validateUser(User loggedUser) {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
	}

	protected List<Trip> tripsBy(User user) {
		return tripDAO.tripsBy(user);
	}	
}

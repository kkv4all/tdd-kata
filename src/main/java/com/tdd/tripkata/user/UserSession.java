package com.tdd.tripkata.user;

public class UserSession {
private static final UserSession userSession = new UserSession();
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		throw new RuntimeException("Method not Implemented"); 
	}

	public User getLoggedUserFromSession() {
		return getInstance().getLoggedUser();
	}
}

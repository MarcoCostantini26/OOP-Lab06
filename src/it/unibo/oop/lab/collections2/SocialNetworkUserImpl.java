package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {
	
	Map<String, Set<U>> users = new HashMap<>();

    /**
     * Builds a new {@link SocialNetworkUserImpl1}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
	public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }
    
    public SocialNetworkUserImpl(final String firstName, final String lastName, final String username) {
        this(firstName, lastName, username, -1);
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

	@Override
    public boolean addFollowedUser(final String circle, final U user) {
		Set<U> usersFromGroup = this.users.get(circle);
		if(usersFromGroup == null) {
			usersFromGroup = new HashSet<>();
			usersFromGroup.add(user);
			users.put(circle, usersFromGroup);
			return true;
		}
		if(usersFromGroup.contains(user)) {
			return false;
		}else {
			usersFromGroup.add(user);
			users.put(circle, usersFromGroup);
			return true;
		}
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	Collection<U> usersFollowedInGroup = this.users.get(groupName);
    	if (usersFollowedInGroup != null) {
    		 return new ArrayList<>(usersFollowedInGroup);
    	}
    		return Collections.emptyList();
    }

    @Override
    public List<U> getFollowedUsers() {
    	List <U> followedUsers = new ArrayList<>();
    	for(String groupName : users.keySet()) {
    		followedUsers.addAll(getFollowedUsersInGroup(groupName));
    	}
        return followedUsers;
    }

}

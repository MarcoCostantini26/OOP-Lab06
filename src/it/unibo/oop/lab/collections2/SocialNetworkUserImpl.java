package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
	
	// nome del gruppo, tutti gli utenti registrati in quel gruppo 
	Map<String, Set<U>> users = new HashMap<>();
	
    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

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
        return new ArrayList<U>(users.get(groupName));
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

package ru.job4j.stream;

import junit.framework.TestCase;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {

    public void testCollect() {
        Profiles pr = new Profiles();
        Profile profile1 = new Profile(new Address("City", "City Street", 77, 7));
        Profile profile2 = new Profile(new Address("City", "City Street", 88, 8));
        Profile profile3 = new Profile(new Address("City", "City Street", 99, 9));
        List<Profile> profiles = List.of(profile1, profile2, profile3);
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = List.of(
                profile1.getAddress(),
                profile2.getAddress(),
                profile3.getAddress()
        );
        assertThat(rsl, is(expected));
    }
}
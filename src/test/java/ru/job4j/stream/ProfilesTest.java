package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("City", "City Street", 77, 7)));
        profiles.add(new Profile(new Address("City", "City Street", 88, 8)));
        profiles.add(new Profile(new Address("City", "City Street", 99, 9)));
        profiles.add(new Profile(new Address("City", "City Street", 99, 9)));
        profiles.add(new Profile(new Address("ACity", "City Street", 9, 99)));
        profiles.add(new Profile(new Address("BCity", "City Street", 77, 7)));
        profiles.add(new Profile(new Address("ACity", "City Street", 9, 99)));
    }

    public void testCollect() {
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("ACity", "City Street", 9, 99));
        expected.add(new Address("BCity", "City Street", 77, 7));
        expected.add(new Address("City", "City Street", 77, 7));
        expected.add(new Address("City", "City Street", 88, 8));
        expected.add(new Address("City", "City Street", 99, 9));
        assertThat(rsl, is(expected));
    }
}
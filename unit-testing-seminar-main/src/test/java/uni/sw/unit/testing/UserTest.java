package uni.sw.unit.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;


public class UserTest{

    @Test
    public void defaultConstructorTest()
    {
        User user = new User();
        assertNotNull(user, "User object should be not null");
        assertNull(user.getUserName());
        assertNull(user.getPassword());
        assertEquals(0,user.getId());
        assertThrows(
          UnsupportedOperationException.class,
          user::isLoggedIn,
          "method should throw exception"
        );
    }

    @Test
    public void mockitoTest()
    {
        User user = mock(User.class);

        when(user.getUserName()).thenReturn("TesztElek");
        when(user.getPassword()).thenReturn("TOPSECRET");
        when(user.isLoggedIn()).thenReturn(true);
        when(user.getId()).thenReturn(123);

        assertEquals("TesztElek",user.getUserName(),"Should be TesztElek");
        assertEquals("TOPSECRET",user.getPassword(),"Should be TOPSECRET");
        assertTrue(user.isLoggedIn(),"Should be true");
        assertEquals(123,user.getId(),"Should be 123");

        verify(user).getUserName();
        verify(user).getPassword();
        verify(user).isLoggedIn();
        verify(user).getId();

        assertEquals(9,user.getPassword().length());
        verify(user, times(2)).getPassword();

        doThrow(new UnsupportedOperationException()).when(user).isLoggedIn();
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn, "Problem");

        when(user.getAcademicAverage(anyInt())).thenReturn(4.6);
        assertEquals(4.6, user.getAcademicAverage(2));
        assertEquals(4.6, user.getAcademicAverage(3));
        verify(user, times(2)).getAcademicAverage(anyInt());

        when(user.update(anyString(),eq(true))).thenReturn(true);
        when(user.update(anyString(),eq(false))).thenReturn(false);
        assertTrue(user.update("pass1",true),"Should be true");
        assertFalse(user.update("pass2",false),"Should be false");
        verify(user, times(1)).update("pass1",true);
        verify(user, times(1)).update("pass2",false);
    }
}

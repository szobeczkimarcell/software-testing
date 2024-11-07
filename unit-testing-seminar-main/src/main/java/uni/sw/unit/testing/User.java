package uni.sw.unit.testing;

public class User {
    private String userName;
    private String password;
    private int id;

    public boolean isLoggedIn()
    {
        throw new UnsupportedOperationException();
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public int getId()
    {
        return id;
    }

    public double getAcademicAverage(int semester)
    {
        return 2.5;
    }

    public boolean update(String newPassword, boolean isLoggedIn)
    {
        return true;
    }
}

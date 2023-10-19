package tests;

import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getHomepage();
        navPage.checkUrl();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.getProfilePage();
        navPage.checkUrl();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        navPage.getAdminCitiesPage();
        navPage.checkUrl();
    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        navPage.getAdminUsersPage();
        navPage.checkUrl();
    }
}

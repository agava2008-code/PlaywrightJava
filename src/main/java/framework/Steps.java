package framework;

import steps.MainSteps;

public class Steps {
    public MainSteps main;
//    public ProfileSteps profile;
//    public CartSteps cart;
// add more steps here

    public Steps(Injector injector) {
        this.main = injector.get(MainSteps.class);
//        this.profile = injector.get(ProfileSteps.class);
//        this.cart = injector.get(CartSteps.class);
    }

}

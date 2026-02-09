package framework;

import steps.ElementSteps;
import steps.MainSteps;
import steps.TextBoxSteps;

public class Steps {
    public MainSteps main;
    public ElementSteps elementSteps;
    public TextBoxSteps textBoxSteps;

// add more steps here

    public Steps(Injector injector) {
        this.main = injector.get(MainSteps.class);
        this.elementSteps = injector.get(ElementSteps.class);
        this.textBoxSteps = injector.get(TextBoxSteps.class);
    }

}

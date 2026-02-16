package framework;

import ui.steps.ElementSteps;
import ui.steps.MainSteps;
import ui.steps.TextBoxSteps;

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

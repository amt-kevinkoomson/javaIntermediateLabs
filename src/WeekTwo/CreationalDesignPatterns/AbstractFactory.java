package WeekTwo.CreationalDesignPatterns;

// Abstract product: Button interface
interface Button {
    void click();
}

// Concrete product: WindowsButton implementation
class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}

// Concrete product: MacOSButton implementation
class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("MacOS button clicked");
    }
}

// Abstract product: Checkbox interface
interface Checkbox {
    void check();
}

// Concrete product: WindowsCheckbox implementation
class WindowsCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Windows checkbox checked");
    }
}

// Concrete product: MacOSCheckbox implementation
class MacOSCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("MacOS checkbox checked");
    }
}

// Abstract factory interface for creating UI components
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factory for Windows UI components
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete factory for MacOS UI components
class MacOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client class to use the UI components
public class AbstractFactory {
    private UIFactory uiFactory;

    public AbstractFactory(UIFactory uiFactory) {
        this.uiFactory = uiFactory;
    }

    public void createUI() {
        Button button = uiFactory.createButton();
        Checkbox checkbox = uiFactory.createCheckbox();

        // Use the created UI components
        button.click();
        checkbox.check();
    }

    public static void main(String[] args) {
        // Create Windows UI
        AbstractFactory windowsAbstractFactory = new AbstractFactory(new WindowsUIFactory());
        windowsAbstractFactory.createUI();

        // Create MacOS UI
        AbstractFactory macOSAbstractFactory = new AbstractFactory(new MacOSUIFactory());
        macOSAbstractFactory.createUI();
    }
}


package frc.robot.abstraction.supersystems;

public class ManagerState {
    
    String stateName;
    Runnable runnable;
    public ManagerState(String stateName, Runnable runnable) {
        this.stateName = stateName;
        this.runnable = runnable;
    }

    public void runRunnable() {
        runnable.run();
    }

    public String getStateName() {
        return stateName;
    }
}

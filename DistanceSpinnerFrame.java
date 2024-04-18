import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Activity 10-11.3
public class DistanceSpinnerFrame extends JFrame implements ChangeListener {
    private JLabel mileLabel;       // Label for miles
    private JLabel kmLabel;         // Label for kilometers
    private JSpinner mileSpinner;   // Triggers mile input for conversion
    private JTextField kmField;     // Displays distance in kilometers

    /* Constructor creates GUI components and adds GUI components using
       a GridBagLayout. */
    DistanceSpinnerFrame() {
        int initMile;       // Spinner initial value display
        int minMile;        // Spinner minimum value
        int maxMile;        // Spinner maximum value
        int stepVal;        // Spinner step value

        initMile = 0;
        minMile = 0;
        maxMile = 500;
        stepVal = 1;

        // Used to specify GUI component layout
        GridBagConstraints layoutConst = null;

        // Specifies the types of value displayed in spinner
        SpinnerNumberModel spinnerModel = null;

        // Set frame's title
        setTitle("Distance Spinner Frame");

        // Create labels
        mileLabel = new JLabel("Select distance in miles (mi):");
        kmLabel = new JLabel("Distance in kilometers (km):");

        // Create a spinner model, the spinner, and set the change listener
        spinnerModel = new SpinnerNumberModel(initMile, minMile, maxMile, stepVal);
        mileSpinner = new JSpinner(spinnerModel);
        mileSpinner.addChangeListener(this);

        // Create field
        kmField = new JTextField(15);
        kmField.setEditable(true);
        kmField.setText("0.0");

        // Use a GridBagLayout
        setLayout(new GridBagLayout());

        // Specify components' grid location
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(mileLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(mileSpinner, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(kmLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(kmField, layoutConst);
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        double totMiles;       // miles input
        double totKmeters;

        totMiles = ((Integer) mileSpinner.getValue()).doubleValue();
        totKmeters = totMiles * 1.60934;

        kmField.setText(Double.toString(totKmeters));
    }

    // Creates a DistanceSpinnerFrame and makes it visible
    public static void main(String[] args){
        DistanceSpinnerFrame myFrame = new DistanceSpinnerFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}

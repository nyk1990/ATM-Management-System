package mdaefsm.state;

import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.IDLE;

/**
 * This class is used for representing Start state
 */
public class StartState extends State {

	public StartState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	public void open() {
		outputProcessor.storeData();
		model.changeState(IDLE);
	}
}

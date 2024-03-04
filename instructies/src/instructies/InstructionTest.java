package instructies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InstructionTest {
	
	@Test
	public void testInstructions() {
		Instruction[] instructs = new Instruction[6];
		instructs[0] = new LoadConstant(2,1);
		instructs[1] = new JumpIfZero(1,5);
		instructs[2] = new Multiply(2,0);
		instructs[3] = new Decrement(1);
		instructs[4] = new Jump(1);
		instructs[5] = new Halt();
		
		int[] registers = new int[] {2,3,0,0};
		Main.execute(registers, instructs);
		assertEquals(8, registers[2]);
	}

}

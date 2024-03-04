package instructies;

abstract class Instruction {
	
}

class LoadConstant extends Instruction {
	 private int r;
	 private int c;
	 
	 public LoadConstant(int r, int c) {
		 this.r = r;
		 this.c = c;
	 }
	 
	 public int getRegister() {
		 return this.r;
	 }
	 
	 public int getConstant() {
		 return this.c;
	 }
}

class Decrement extends Instruction {
	
	private int r;
	
	public Decrement(int r) {
		this.r = r;
	}
	
	public int getRegister() {
		return this.r;
	}
}

class Multiply extends Instruction {
	
	private int r1;
	private int r2;
	
	public Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	public int[] getRegisters() {
		return new int[] {r1, r2};
	}
}

class JumpIfZero extends Instruction {
	private int r;
	private int a;
	
	public JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
	
	public int getRegister() {
		return this.r;
	}
	
	public int getAdress() {
		return this.a;
	}
}

class Jump extends Instruction {
	private int a;
	
	public Jump(int a) {
		this.a = a;
	}
	
	public int getAdress() {
		return this.a;
	}
}

class Halt extends Instruction {
}


public class Main {
	
	public static void execute(int[] registers, Instruction[] instructions) {
		for (int i = 0; i < instructions.length; i++) {
			Instruction instruction = instructions[i];
			switch(instruction) {
			case LoadConstant lc -> {
				int register = lc.getRegister();
				int constant = lc.getConstant();
				registers[register] = constant;
			}
			case Decrement dc -> {
				int register = dc.getRegister();
				registers[register] -= 1;
			}
			case Multiply m -> {
				int register1 = m.getRegisters()[0];
				int register2 = m.getRegisters()[1];
				registers[register1] *= registers[register2];
			}
			case JumpIfZero jiz -> {
				int register = jiz.getRegister();
				if (registers[register] == 0) {
					int adress = jiz.getAdress();
					i = adress-1; // -1 omdat na executie i zowieso + 1 wordt gedaan
				}
			}
			case Jump j -> {
				i = j.getAdress()-1;
			}
			default -> {
				return;
			}
			}
		}
	}
	

}

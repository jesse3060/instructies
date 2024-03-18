package instructies;

abstract class Instruction {
	
	abstract void execute(Machine m, int[] registers);
	
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
	 
	 @Override
	void execute(Machine m, int[] registers) {
		 registers[r] = c;
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
	
	@Override
	void execute(Machine m, int[] registers) {
		registers[r] -= 1;
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
	
	@Override
	void execute(Machine m, int[] registers) {
		registers[r1] *= registers[r2];
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
	
	@Override
	void execute(Machine m, int[] registers) {
		if (registers[r] == 0)
			m.pc = a-1;
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
	
	@Override
	void execute(Machine m, int[] registers) {
		m.pc = a-1;
	}
}

 class Halt extends Instruction {
	 
	 @Override
	void execute(Machine m, int[] registers) {
		 m.pc = -2;
	}
 }

 
class Add extends Instruction {
	private int a;
	private int r1;
	private int r2;
	
	public Add(int a, int r1, int r2) {
		this.a = a;
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	void execute(Machine m, int[] registers) {
		registers[a] = registers[r1] + registers[r2];
	}
}

public class Machine {
	
	public int pc;
	
	public void execute(int[] registers, Instruction[] instructions) {
		pc = 0;
		while (pc >= 0) {
			Instruction instruction = instructions[pc];
			instruction.execute(this, registers);
			pc++;
		}
	}

}

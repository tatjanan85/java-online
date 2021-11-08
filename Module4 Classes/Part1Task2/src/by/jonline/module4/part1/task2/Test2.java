package by.jonline.module4.part1.task2;

import java.util.Objects;

public class Test2 {

	private int var1;
	private int var2;

	public Test2() {
		var1 = 100;
		var2 = 100;
	}

	public Test2(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}

	public int getVar1() {
		return var1;
	}

	public void setVar1(int var1) {
		this.var1 = var1;
	}

	public int getVar2() {
		return var2;
	}

	public void setVar2(int var2) {
		this.var2 = var2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Test2)) return false;
		Test2 test2 = (Test2) o;
		return var1 == test2.var1 && var2 == test2.var2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(var1, var2);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" +
				"var1=" + var1 +
				", var2=" + var2 +
				'}';
	}
}

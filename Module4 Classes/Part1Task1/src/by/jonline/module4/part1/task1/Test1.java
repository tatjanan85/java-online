package by.jonline.module4.part1.task1;

import java.util.Objects;

public class Test1 {

	private int var1;
	private int var2;

	public Test1() {

	}

	public Test1(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}

	public void setVar1(int var1) {
		this.var1 = var1;
	}

	public void setVar2(int var2) {
		this.var2 = var2;
	}

	public int getVar1() {
		return var1;
	}

	public int getVar2() {
		return var2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Test1)) return false;
		Test1 test1 = (Test1) o;
		return var1 == test1.var1 && var2 == test1.var2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(var1, var2);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" +
				"var1=" + var1 +
				", var2=" + var2 +
				'}';
	}

	public void printVars() {
		System.out.printf("Переменная var1 = %d, переменная var2 = %d\n", var1, var2);
	}

	public int sum() {
		return var1 + var2;
	}

	public int max() {
		return var1 > var2 ? var1 : var2;
	}
}

package ru.avelikorechin.calculator;

/**
	* Class Calculator — решение задачи части 001, урок 2.
	* @author Alexander Velikorechin
	* @since 15.01.2017
*/

public class Calculator {
	/**
		* Описание полей класса Calculator.
		* @param result — результат вычислений.
	*/
	private double result;
	/**
		* Сложение.
		* @param first — первый операнд.
		* @param second — второй операнд.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
		* Вычитание.
		* @param first — первый операнд.
		* @param second — второй операнд.
	*/
	public void substract(double first, double second) {
		this.result = first - second;
	}
	/**
		* Умножение.
		* @param first — первый операнд.
		* @param second — второй операнд.
	*/
	public void multiply(double first, double second) {
		this.result = first * second;
	}
	/**
		* Деление.
		* @param first — первый операнд.
		* @param second — второй операнд.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
		* Возвращает приватное поле result класса Calculator.
		* @return Возвращает результат вычислений.
	*/
	public double getResult() {
		return this.result;
	}
}
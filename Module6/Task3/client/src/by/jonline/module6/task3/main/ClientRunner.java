package by.jonline.module6.task3.main;

import by.jonline.module6.task3.view.View;
import by.jonline.module6.task3.view.action.LoginActionView;

import java.io.IOException;

/**
 * Задание 3: создайте клиент-серверное приложение “Архив”.
 * Общие требования к заданию:
 * • В архиве хранятся Дела (например, студентов). Архив находится на сервере.
 * • Клиент, в зависимости от прав, может запросить дело на просмотр, внести в него изменения, или создать новое дело.
 * Требования к коду лабораторной работы:
 * • Для реализации сетевого соединения используйте сокеты.
 * • Формат хранения данных на сервере – xml-файлы.
 */
public class ClientRunner {

	public static void main(String[] args) {

		try {
			LoginActionView.getInstance().show();
		} catch (IOException e) {
			View.getInstance().printError(e.getMessage());
		}

	}
}



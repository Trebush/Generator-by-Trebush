#include<iostream>
#include<cstdlib>
#include<fstream>
#include<Windows.h>
using namespace std;
void start() {
	cout << "Generator by Trebush" << endl;
}
void programDo() {
	cout << "What is the program supposed to do?" << endl;
	cout << "1 - Login generator" << endl;
	cout << "2 - Password generator" << endl;
	cout << "3 - Login and Password generator" << endl;
}
int Dop() {
	int doP;
	cin >> doP;
	return doP;
}
int loginNumbersHowMany() {
	int loginNumbersMany;
	cout << "How many numbers do You need in your login?" << endl;
	cin >> loginNumbersMany;
	return loginNumbersMany;
}
int loginCharactersHowMany() {
	int loginCharactersMany;
	cout << "How many characters do You need in your login?" << endl;
	cin >> loginCharactersMany;
	return loginCharactersMany;
}
int passwordNumbersHowMany() {
	int passwordNumbersMany;
	cout << "How many numbers do You need in your password?" << endl;
	cin >> passwordNumbersMany;
	return passwordNumbersMany;
}
int passwordCharactersHowMany() {
	int passwordCharactersMany;
	cout << "How many characters do You need in your password?" << endl;
	cin >> passwordCharactersMany;
	return passwordCharactersMany;
}
int loginNumbers(int tab[], int howMany) {
	for (int i = 0; i <= howMany; i++) {
		tab[i] = rand() % 10;
		if (true) {
			return tab[i];
		}
		else {
			return 0;
		}
	}
}
int passwordNumbers(int tab[], int howMany) {
	for (int i = 0; i < howMany; i++) {
		tab[i] = rand() % 10;
		if (true) {
			return tab[i];
		}
		else {
			return 0;
		}
	}
}
int loginSmallCharacters(char tab[], int howMany) {
	for (int i = 0; i < howMany / 2; i++) {
		tab[i] = ((rand() % ('z' - 'a') + 'a'));
		if (true) {
			return tab[i];
		}
		else {
			return 0;
		}
	}
}
int passwordSmallCharacters(char tab[], int howMany) {
	for (int i = 0; i < howMany / 2; i++) {
		tab[i] = ((rand() % ('z' - 'a') + 'a'));
		if (true) {
			return tab[i];
		}
		else {
			return 0;
		}
	}
}
void saveLoginNumbers(int tab[], int howMany, string file, string YesorNo) {
	for (int d = 0; d <= howMany; d++) {
		tab[d] = loginNumbers(tab, howMany);
	}
	if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
		ofstream file2;
		file2.open(file + ".txt", ios::app);
		if (file2.is_open()) {
			for (int i = 0; i < howMany; i++) {
				file2 << tab[i];
			}
			file2 << endl;
		}
		file2.close();
	}
	for (int i = 0; i < howMany; i++) {
		cout << tab[i];
	}
}
void saveLoginCharacters(char tab[], int howMany, string file, string YesorNo) {
	for (int e = 0; e < howMany; e++) {
		tab[e] = loginSmallCharacters(tab, howMany);
	}
	if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
		ofstream file2;
		file2.open(file + ".txt", ios::app);
		if (file2.is_open()) {
			file2 << endl << "Your new Login: ";
			for (int i = 0; i < howMany; i++) {
				file2 << tab[i];
			}
		}
		file2.close();
	}
	cout << endl << "Your new Login: ";
	for (int i = 0; i < howMany; i++) {
		cout << tab[i];
	}
}
void savePasswordNumbers(int tab[], int howMany, string file, string YesorNo) {
	for (int d = 0; d < howMany; d++) {
		tab[d] = passwordNumbers(tab, howMany);
	}
	if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
		ofstream file2;
		file2.open(file + ".txt", ios::app);
		if (file2.is_open()) {
			for (int i = 0; i < howMany; i++) {
				file2 << tab[i];
			}
			file2 << endl;
		}
		file2.close();
	}
	for (int i = 0; i < howMany; i++) {
		cout << tab[i];
	}
}
void savePasswordCharacters(char tab[], int howMany, string file, string YesorNo) {
	for (int e = 0; e < howMany; e++) {
		tab[e] = passwordSmallCharacters(tab, howMany);
	}
	if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
		ofstream file2;
		file2.open(file + ".txt", ios::app);
		if (file2.is_open()) {
			file2 << "Your new Password: ";
			for (int i = 0; i < howMany; i++) {
				file2 << tab[i];
			}
		}
		file2.close();
	}
	cout << endl << "Your new Password: ";
	for (int i = 0; i < howMany; i++) {
		cout << tab[i];
	}
}

void doP() {
	int doP = Dop();
	switch (doP) {
	case 1:
		for (int i = 0; i < 1; i++) {
			string file;
			char* tab;
			int howManyLoginCharacters = loginCharactersHowMany();
			tab = new char[howManyLoginCharacters];
			int* tab1;
			int howManyLoginNumbers = loginNumbersHowMany();
			tab1 = new int[howManyLoginNumbers];
			string YesorNo;
			cout << "Do you want to save to a file? Yes or No" << endl;
			cin >> YesorNo;
			if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
				cout << "Enter the name of the txt file where you want to save it (e.g Login)" << endl;
				cin >> file;
			}
			saveLoginCharacters(tab, howManyLoginCharacters, file, YesorNo);
			saveLoginNumbers(tab1, howManyLoginNumbers, file, YesorNo);
		}
		break;
	case 2:
		for (int i = 0; i < 1; i++) {
			string file;;
			char* tab;
			int howManyPasswordCharacters = passwordCharactersHowMany();
			tab = new char[howManyPasswordCharacters];
			int* tab1;
			int howManyPasswordNumbers = passwordNumbersHowMany();
			tab1 = new int[howManyPasswordNumbers];
			string YesorNo;
			cout << "Do you want to save to a file? Yes or No" << endl;
			cin >> YesorNo;
			if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
				cout << "Enter the name of the txt file where you want to save it (e.g Login.txt)" << endl;
				cin >> file;
			}
			savePasswordCharacters(tab, howManyPasswordCharacters, file, YesorNo);
			savePasswordNumbers(tab1, howManyPasswordNumbers, file, YesorNo);
		}
		break;
	case 3:
		for (int i = 0; i < 1; i++) {
			string file;
			char* tab;
			int howManyLoginCharacters = loginCharactersHowMany();
			tab = new char[howManyLoginCharacters];
			int* tab1;
			int howManyLoginNumbers = loginNumbersHowMany();
			tab1 = new int[howManyLoginNumbers];
			char* tab2;
			int howManyPasswordCharacters = passwordCharactersHowMany();
			tab2 = new char[howManyPasswordCharacters];
			int* tab3;
			int howManyPasswordNumbers = passwordNumbersHowMany();
			tab3 = new int[howManyPasswordNumbers];
			string YesorNo;
			cout << "Do you want to save to a file? Yes or No" << endl;
			cin >> YesorNo;
			if (YesorNo == "Yes" || YesorNo == "yes" || YesorNo == "y" || YesorNo == "Y") {
				cout << "Enter the name of the txt file where you want to save it (e.g Login.txt)" << endl;
				cin >> file;
			}
			saveLoginCharacters(tab, howManyLoginCharacters, file, YesorNo);
			saveLoginNumbers(tab1, howManyLoginNumbers, file, YesorNo);
			savePasswordCharacters(tab2, howManyPasswordCharacters, file, YesorNo);
			savePasswordNumbers(tab3, howManyPasswordNumbers, file, YesorNo);
		}
		break;
	default:
		cout << "Wrong Numbers!!";
		break;
	}
}
void end() {
	cout << endl << "Thank you for using ~ Trebush" << endl;
	cout << "Copyright (c) 2021 Trebush" << endl;
	cout << "All rights reserved." << endl;
}
int main() {
	srand((unsigned int)time(NULL));
	start();
	programDo();
	doP();
	end();
	system("PAUSE");
}
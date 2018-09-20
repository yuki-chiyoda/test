package com.internousdev.glanq.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	public List<String> docheck(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana,
			boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana,
			boolean availableFullWidthSymbols) {

		/**
		 * 入力された文字列がこちらが指定するものになっているかを確認するクラス 行う処理は ①値が空欄かどうか ②入力文字数内に収まっているかどうか
		 * ③こちらの意図した文字列が入力されているか
		 *
		 * また、 ④引数として渡された「登録済パスワード」と「再確認用パスワード」が等しいかどうか という処理も行う
		 */

		List<String> resultList = new ArrayList<String>(); // 結果
		List<String> messageList = new ArrayList<String>(); // メッセージ

		/**
		 * 結果を入れ、最終的に戻すリストと 実際に表示するメッセージを格納するリストを用意
		 */

		// ①入力内容が空欄かどうか
		if (StringUtils.isEmpty(value)) {
			resultList.add(propertyName + "を入力してください");
		}

		// ②入力文字数内に収まっているかどうか
		if ((value.length() < minLength || value.length() > maxLength) && (!(StringUtils.isEmpty(value)))) {
			resultList.add(propertyName + "は、" + minLength + "文字以上" + maxLength + "文字以下で入力してください");
		}

		// ③こちらの意図した文字列が入力されているか
		String regularExpression = ""; // 正しい表現
		/**
		 * 正しい表現を入れるString型変数を用意
		 *
		 * if文を用いて これから、使用可能な文字を格納していく 渡された引数がtrue(使用可能)な場合は その文字を格納
		 *
		 * また、本来入れるべき文字列について メッセージリストにもメッセージを入れていく
		 */

		// まず始まりの括弧
		if (availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits
				|| availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols) {
			regularExpression += "[";
		}

		// 半角英字は使用可能かどうか
		if (availableAlphabeticCharacters) {
			regularExpression += "a-zA-Z";
			messageList.add("半角英字");
		}

		// 漢字は使用可能かどうか
		if (availableKanji) {
			regularExpression += "一-龯";
			messageList.add("漢字");
		}

		// ひらがなは使用可能かどうか
		if (availableHiragana) {
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}

		// 半角数字は使用可能かどうか
		if (availableHalfWidthDigits) {
			regularExpression += "0-9";
			messageList.add("半角数字");
		}

		// 半角記号は使用可能かどうか
		if (availableHalfWidthSymbols) {
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~() ";
			messageList.add("半角記号");
		}

		// カタカナは使用可能かどうか
		if (availableKatakana) {
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}

		// 全角記号は使用可能かどうか
		if (availableFullWidthSymbols) {
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～ー、。　";
			messageList.add("全角記号");
		}

		// 括弧を閉じる。これでそれぞれ"[^○○○]+"の形になる。
		if (!StringUtils.isEmpty(regularExpression)) {
			regularExpression += "]+";
		}

		/**
		 * メッセージリスト内の要素をString型の変数に入れていく for文を利用し、要素の数だけ要素を変数に格納していく
		 *
		 * 同時にメッセージリストの中身を整理する 現状では「半角英字漢字ひらがな」のように隙間なく詰め込まれているため 「、」で区切る
		 * ただし、最初は必要ないためif分で分岐させていく
		 */
		String message = "";
		for (int i = 0; i < messageList.size(); i++) {
			if (i == 0) {
				message += messageList.get(i).toString();
			} else {
				message += "、" + messageList.get(i).toString();
			}
		}

		// 入力された値を正しい表現、誤った表現と比較し状況に応じてエラーメッセージを返す
		if (regularExpression.equals("")) {
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		} else {
			if ((!value.matches(regularExpression) && !value.equals(""))) {
				resultList.add(propertyName + "は、" + message + "で入力してください。");
			}
		}
		return resultList;
	}

	public List<String> docheck2(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana,
			boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana,
			boolean availableFullWidthSymbols) {

		List<String> resultList = new ArrayList<String>(); // 結果
		List<String> messageList = new ArrayList<String>(); // メッセージ

		// ①入力内容が空欄かどうか
		if (StringUtils.isEmpty(value)) {
			resultList.add(propertyName + "を入力してください");
		}

		// ②入力文字数内に収まっているかどうか
		if ((value.length() < minLength || value.length() > maxLength) && (!(StringUtils.isEmpty(value)))) {
			resultList.add(propertyName + "は、" + minLength + "桁以上" + maxLength + "桁以下で入力してください");
		}

		// ③こちらの意図した文字列が入力されているか
		String regularExpression = ""; // 正しい表現

		// まず始まりの括弧
		if (availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits
				|| availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols) {
			regularExpression += "[";
		}

		// 半角英字は使用可能かどうか
		if (availableAlphabeticCharacters) {
			regularExpression += "a-zA-Z";
			messageList.add("半角英字");
		}

		// 漢字は使用可能かどうか
		if (availableKanji) {
			regularExpression += "一-龯";
			messageList.add("漢字");
		}

		// ひらがなは使用可能かどうか
		if (availableHiragana) {
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}

		// 半角数字は使用可能かどうか
		if (availableHalfWidthDigits) {
			regularExpression += "0-9";
			messageList.add("半角数字");
		}

		// 半角記号は使用可能かどうか
		if (availableHalfWidthSymbols) {
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~() ";
			messageList.add("半角記号");
		}

		// カタカナは使用可能かどうか
		if (availableKatakana) {
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}

		// 全角記号は使用可能かどうか
		if (availableFullWidthSymbols) {
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～ー、。　";
			messageList.add("全角記号");
		}

		// 括弧を閉じる。これでそれぞれ"[^○○○]+"の形になる。
		if (!StringUtils.isEmpty(regularExpression)) {
			regularExpression += "]+";
		}

		String message = "";
		for (int i = 0; i < messageList.size(); i++) {
			if (i == 0) {
				message += messageList.get(i).toString();
			} else {
				message += "、" + messageList.get(i).toString();
			}
		}

		// 入力された値を正しい表現、誤った表現と比較し状況に応じてエラーメッセージを返す
		if (regularExpression.equals("")) {
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		} else {
			if ((!value.matches(regularExpression) && !value.equals(""))) {
				resultList.add(propertyName + "は、" + message + "で入力してください。");
			}
		}
		return resultList;
	}

	public List<String> docheck3(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana,
			boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana,
			boolean availableFullWidthSymbols) {

		List<String> resultList = new ArrayList<String>(); // 結果
		List<String> messageList = new ArrayList<String>(); // メッセージ

		// ②入力文字数内に収まっているかどうか
		if ((value.length() < minLength || value.length() > maxLength) && (!(StringUtils.isEmpty(value)))) {
			resultList.add(propertyName + "は、" + minLength + "文字以上" + maxLength + "文字以下で挿入してください");
		}

		// ③こちらの意図した文字列が入力されているか
		String regularExpression = ""; // 正しい表現

		// まず始まりの括弧
		if (availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits
				|| availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols) {
			regularExpression += "[";
		}

		// 半角英字は使用可能かどうか
		if (availableAlphabeticCharacters) {
			regularExpression += "a-zA-Z";
			messageList.add("半角英字");
		}

		// 漢字は使用可能かどうか
		if (availableKanji) {
			regularExpression += "一-龯";
			messageList.add("漢字");
		}

		// ひらがなは使用可能かどうか
		if (availableHiragana) {
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}

		// 半角数字は使用可能かどうか
		if (availableHalfWidthDigits) {
			regularExpression += "0-9";
			messageList.add("半角数字");
		}

		// 半角記号は使用可能かどうか
		if (availableHalfWidthSymbols) {
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~() ";
			messageList.add("半角記号");
		}

		// カタカナは使用可能かどうか
		if (availableKatakana) {
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}

		// 全角記号は使用可能かどうか
		if (availableFullWidthSymbols) {
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～ー、。　";
			messageList.add("全角記号");
		}

		// 括弧を閉じる。これでそれぞれ"[^○○○]+"の形になる。
		if (!StringUtils.isEmpty(regularExpression)) {
			regularExpression += "]+";
		}

		String message = "";
		for (int i = 0; i < messageList.size(); i++) {
			if (i == 0) {
				message += messageList.get(i).toString();
			} else {
				message += "、" + messageList.get(i).toString();
			}
		}

		// 入力された値を正しい表現、誤った表現と比較し状況に応じてエラーメッセージを返す
		if (regularExpression.equals("")) {
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		} else {
			if ((!value.matches(regularExpression) && !value.equals(""))) {
				resultList.add(propertyName + "は、" + message + "で入力してください。");
			}
		}
		return resultList;
	}

	// ④引数として渡された「新しいパスワード」と「再確認用パスワード」が等しいかどうか
	public List<String> doPasswordCheck(String newPassword, String reConfirmationPassward) {
		List<String> resultList = new ArrayList<String>();
		if (!(newPassword.equals(reConfirmationPassward))) {
			resultList.add("確認用パスワードが異なります。");
		}
		/**
		 * 引数として渡された2つのパスワードが等しいかどうか if文で分岐させる
		 *
		 * 一致しなければエラーメッセージを格納
		 */
		return resultList;
	}

}

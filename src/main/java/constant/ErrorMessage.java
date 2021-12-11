package constant;

public class ErrorMessage {

    public static final String HOLDING_MONEY_NOT_A_VALID_NUMBER = "[ERROR] 자판기 보유 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    public static final String HOLDING_MONEY_NOT_A_POSITIVE_NUMBER = "[ERROR] 자판기 보유 금액은 0 이상이어야 합니다.";
    public static final String HOLDING_MONEY_NOT_DIVISIBLE_BY_TEN = "[ERROR] 자판기 보유 금액의 최소 단위는 10이어야 합니다.";

    public static final String PRODUCT_INVALID_FORMAT = "[ERROR] 상품 정보 형식이 올바르지 않습니다. \"[상품명1, 상품 가격1, 상품 수량1];[상품명2, 상품 가격2, 상품 수량2]...\" 형식으로 입력해 주세요.";
    public static final String PRODUCT_DROPPED_INFO = "[ERROR] 누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
    public static final String PRODUCT_INVALID_NAME = "[ERROR] 상품명은 한글, 숫자, 영문으로만 이루어진 이름이어야 합니다.";
    public static final String PRODUCT_NOT_A_VALID_NUMBER_PRICE = "[ERROR] 상품 가격은 반드시 10억 이하의 숫자여야 합니다.";
    public static final String PRODUCT_LESS_THAN_100_PRICE = "[ERROR] 상품 가격은 반드시 100원 이상이어야 합니다.";
    public static final String PRODUCT_NOT_DIVISIBLE_BY_10_PRICE = "[ERROR] 상품 가격의 최소 단위는 10이어야 합니다.";
    public static final String PRODUCT_NOT_A_VALID_NUMBER_STOCK = "[ERROR] 상품 수량은 반드시 10억 이하의 숫자여야 합니다.";
    public static final String PRODUCT_LESS_THAN_0_STOCK = "[ERROR] 상품 수량은 반드시 0 이상이어야 합니다.";

    public static final String INPUT_AMOUNT_NOT_A_VALID_NUMBER = "[ERROR] 투입 금액은 10억 이하의 숫자만 입력할 수 있습니다.";
    public static final String INPUT_AMOUNT_NOT_A_POSITIVE_NUMBER = "[ERROR] 투입 금액은 0 이상이어야 합니다.";
    public static final String INPUT_AMOUNT_SHORTAGE = "[ERROR] 투입 금액이 부족합니다.";

    public static final String PRODUCT_NAME_TO_PURCHASE_INVALID = "[ERROR] 올바른 상품명을 입력해 주세요.";
    public static final String PRODUCT_IS_NOT_EXIST = "[ERROR] 입력하신 상품명과 일치하는 상품이 존재하지 않습니다. 상품명을 다시 한 번 확인하여 주세요.";
    public static final String PRODUCT_IS_SOLD_OUT = "[ERROR] 현재 해당 상품의 재고가 없습니다. 다른 상품을 선택해 주세요.";
}

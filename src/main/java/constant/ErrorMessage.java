package constant;

public class ErrorMessage {
    public static final String PRODUCT_FORMAT_ERROR_MESSAGE = "[ERROR] 상품 정보 형식이 올바르지 않습니다. \"[상품명1, 상품 가격1, 상품 수량1];[상품명2, 상품 가격2, 상품 수량2]...\" 형식으로 입력해 주세요.";
    public static final String DROPPED_INFO_ERROR_MESSAGE = "[ERROR] 누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
    public static final String NOT_A_VALID_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 반드시 10억 이하의 숫자여야 합니다.";
    public static final String NOT_A_VALID_NUMBER_STOCK_ERROR_MESSAGE = "[ERROR] 상품 수량은 반드시 10억 이하의 숫자여야 합니다.";
    public static final String LESS_THAN_100_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 반드시 100원 이상이어야 합니다.";
    public static final String LESS_THAN_0_STOCK_ERROR_MESSAGE = "[ERROR] 상품 수량은 반드시 0 이상이어야 합니다.";
    public static final String NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격의 최소 단위는 10이어야 합니다.";
    public static final String INVALID_PRODUCT_NAME_ERROR_MESSAGE = "[ERROR] 상품명은 한글, 숫자, 영문으로만 이루어진 이름이어야 합니다.";
}

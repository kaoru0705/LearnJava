package p2;

public class App {
    public static void main(String[] args) {

    }
}

// 90%가 이런 구조
// Tree 구조 무조건 3중 for문으로 돌려야 된다. 1티어 2티어 3티어 배열
// 재귀로 못 품
class ShopDto {
    String name;
    // .. 기타 추가 정보들..

    ProductDto[] productList = new ProductDto[5];
}

class ProductDto {
    String name;
    // .. 기타 추가 정보들..
    OptionDto[] optionList = new OptionDto[5];
}

class OptionDto {
    String name;
    // .. 기타 추가 정보들..

}
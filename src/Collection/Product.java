package Collection;

class Product{
  String name;
  String id;
  double price;
  String createdDate;

  public Product(String name, String id, double price, String createdDate) {
    this.name = name;
    this.id = id;
    this.price = price;
    this.createdDate = createdDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Product{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", price='" + price + '\'' +
            ", createdDate='" + createdDate + '\'' +
            '}';
  }
}

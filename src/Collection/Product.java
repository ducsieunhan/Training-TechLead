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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
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

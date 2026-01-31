# Library App (Library Management System)

**Spring Boot** tabanlı bir RESTful API uygulamasıdır. Veri kalıcılığı için **PostgreSQL** kullanır ve **Docker** ile konteynerize edilmiştir.

## 🚀 Teknolojiler

Projede kullanılan temel teknoloji yığını:

* **Java 21**
* **Spring Boot 4.x**
    * Spring Web
    * Spring Data JPA
    * Spring Boot Docker Compose Support
* **Veritabanı:** PostgreSQL
* **Konteynerizasyon:** Docker & Docker Compose
* **Build Tool:** Maven
* **Dokümantasyon:** OpenAPI (Swagger) ile otomatik API dokümantasyonu.
* **Loglama:** Log4j2 ile hata ve bilgi loglama altyapısı.

## 🐳 Kurulum ve Çalıştırma (Docker - Önerilen)

Bu proje, veritabanı ve uygulama bağımlılıklarını yönetmek için Docker Compose kullanır. En kolay kurulum yöntemi budur.

1.  Projeyi klonlayın:
    ```bash
    git clone https://github.com/kadriacibadem/libraryapp.git
    cd libraryapp
    ```

2.  Docker Compose ile uygulamayı ayağa kaldırın:
    ```bash
    docker-compose up -d
    ```
3.  Uygulamanın çalıştığını test edin:
    ```
    http://localhost:8080/swagger-ui/index.html
    ```

5.  Durdurmak için:
    ```bash
    docker-compose down
    ```

## 🔌 API Uç Noktaları (Endpoints)

### 📖 Book Controller

| HTTP Metodu | Uç Nokta (Endpoint) | Açıklama |
| :--- | :--- | :--- |
| `POST` | `/api/book/create` | Yeni bir kitap oluşturur. |
| `GET` | `/api/book/get/{title}` | Başlığa göre kitap detaylarını getirir. |
| `PUT` | `/api/book/update` | Kitap bilgilerini günceller (ISBN13 zorunlu). |
| `DELETE` | `/api/book/delete/{isbn13}` | ISBN numarasına göre kitabı siler. |
| `GET` | `/api/book/books` | Kayıtlı tüm kitapları listeler. |
| `GET` | `/api/book/books-start-with-a` | İsmi 'A' harfi ile başlayan kitapları filtreler. |
| `GET` | `/api/book/search/{bookName}` | **Google Books API** üzerinden global arama yapar. |

### ✍️ Author Controller

| HTTP Metodu | Uç Nokta (Endpoint) | Açıklama |
| :--- | :--- | :--- |
| `GET` | `/api/author/authors` | Sistemdeki tüm yazarları listeler. |

### 🏢 Publisher Controller

| HTTP Metodu | Uç Nokta (Endpoint) | Açıklama |
| :--- | :--- | :--- |
| `GET` | `/api/publisher/publishers` | Sistemdeki tüm yayınevlerini listeler. |

---

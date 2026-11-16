import java.text.Normalizer;

String slugify(String title) {
    return Normalizer.normalize(title, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "")          // bỏ dấu
            .replace('đ', 'd')
            .replace('Đ', 'D')
            .toLowerCase()
            .replaceAll("[^a-z0-9]+", "-")     // ký tự khác chữ, số thành "-"
            .replaceAll("(^-+|-+$)", "");      // bỏ "-" ở đầu và cuối
}

int countWords(String text) {
    String t = text.trim();
    if (t.isEmpty()) return 0;
    return t.split("\\s+").length;
}

void main() {
    String[] titles = {
            "Xin chào Java",
            "  Học Spring Boot 4 trong 30 ngày!!  ",
            "Đừng bỏ cuộc giữa chừng",
            ""
    };
    for (String t : titles) {
        IO.println("[" + t + "] → " + slugify(t) + " (" + countWords(t) + " từ)");
    }
}
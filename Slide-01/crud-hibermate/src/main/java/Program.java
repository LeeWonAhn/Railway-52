import entity.Department;
import repository.DepartmentRepository;

import java.util.List;

public class Program {

    /*
     * Các bước tạo Project
     * Bước 1: Tạo maven project
     * Bước 2: Thêm thư viện hibernate core và mysql connector java
     * Bước 3: Tạo cấu hình hibernate
     * Bước 4: Tạo thưc thể maping
     * Bước 5: Viết chương trình chạy
     */

    /*
     * @Entity: Đánh dấu 1 class trong java dùng để map sang table trong database
     * @Table: Cấu hình cho bảng: tên, database,...
     * @Id: Đánh dấu 1 trường là khóa chính
     * @Column: Cấu hình thêm cho cột
     * @GeneratedValue: Tạo khóa chính tự động tăng
     */

    /*
    * Quy ước code
    * Với database: Dùng kiểu:   snake_case
    * Với java: Dùng kiểu:
    *                       - Biến: camelCase
    *                       - Package: viết thường hết
    *                       - Class: PascalCase
     */
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        System.out.println("--------CREATE------------");
        Department departmentA = new Department();
        departmentA.setName("Ky Thuat");
        departmentRepository.create(departmentA);

        Department departmentB = new Department();
        departmentB.setName("Giam doc");
        departmentRepository.create(departmentB);
        System.out.println("--------FIND ALL------------");
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }
        System.out.println("--------FIND BY ID------------");
        Department departmentByID = departmentRepository.findById(1);
        System.out.println("departmentByID = " + departmentByID);

        System.out.println("--------FIND BY NAME------------");
        Department departmentByName = departmentRepository.findByName("Giam doc");
        System.out.println("departmentByName = " + departmentByName);

        System.out.println("-------- UPDATE ------------");
        departmentByID.setName("Bao Ve");
        departmentRepository.update(departmentByID);

        System.out.println("-------- DELETE BY ID ------------");
        departmentRepository.deleteById(2);

        System.out.println("------------------------ FIND ALL ------------------------");

        for (Department department : departmentRepository.findAll()) {
            System.out.println("department = " + department);
        }
    }
}

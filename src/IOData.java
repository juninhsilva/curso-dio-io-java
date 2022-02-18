import java.io.*;
import java.util.Scanner;

public class IOData {
    public static void incluirProduto(Roupa roupa) throws IOException {
        File file = new File("/home/juninhsilva14/Documents/SI/cursos/curso-dio-io-java/roupa.bin");
        PrintStream printStream = new PrintStream(System.out);
        printStream.flush();

        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file.getPath()));

        Scanner scanner = new Scanner(System.in);
        printStream.print("Nome da Peça: ");
        roupa.setNome(scanner.nextLine());
        printStream.print("Tamanho da Peça: ");
        roupa.setTamanho(scanner.next());
        printStream.print("Quantidade da Peça: ");
        roupa.setQuantidade(scanner.nextInt());
        printStream.print("Preço da Peça: ");
        roupa.setPreco(scanner.nextFloat());

        printStream.flush();

        dataOutputStream.writeUTF(roupa.getNome());
        dataOutputStream.writeUTF(roupa.getTamanho());
        dataOutputStream.writeInt(roupa.getQuantidade());
        dataOutputStream.writeDouble(roupa.getPreco());

        lerProduto(file.getPath());
        dataOutputStream.close();
    }

    public static void lerProduto(String arquivo) throws IOException {
        File file = new File(arquivo);
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file.getPath()));
        PrintStream printStream = new PrintStream(System.out);
        printStream.flush();
        Roupa roupa = new Roupa();

        roupa.setNome(inputStream.readUTF());
        roupa.setTamanho(inputStream.readUTF());
        roupa.setQuantidade(inputStream.readInt());
        roupa.setPreco(inputStream.readDouble());

        printStream.print("\n\nRESULTADO\n");
        printStream.printf("Nome da Peça: %s\n", roupa.getNome());
        printStream.printf("Tamanho da Peça: %s\n", roupa.getTamanho());
        printStream.printf("Quantidade da Peça: %d\n", roupa.getQuantidade());
        printStream.printf("Preço da Peça: %f\n", roupa.getPreco());
        printStream.printf("Valor Total das Peças: %f\n", roupa.getPreco() * roupa.getQuantidade());

        printStream.flush();

        printStream.close();
        inputStream.close();
    }

    public static void main(String[] args) throws IOException {

        Roupa roupa = new Roupa();
        incluirProduto(roupa);
    }
}

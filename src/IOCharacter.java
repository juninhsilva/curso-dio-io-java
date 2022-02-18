import java.io.*;
import java.util.Scanner;

public class IOCharacter {
    public static void tecladoConsole() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Recomende 3 filmes: ");
        String line = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        do {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        }while (!line.isEmpty());

        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();

    }

    public static void escreverDocumento() throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("3 filmes");
        printWriter.flush();

        Scanner scanner = new Scanner(System.in);
        String line2 = scanner.nextLine();

        File file = new File("recomendacoes.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getName()));

        do {
            bufferedWriter.write(line2);
            bufferedWriter.newLine();
            line2 = scanner.nextLine();
        }while (!line2.equalsIgnoreCase("fim"));

        printWriter.printf("Arquivo \"%s\" foi criado com sucesso!", file.getName());
        printWriter.flush();
        printWriter.close();
        scanner.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void copiarArquivo() throws IOException {
        File file = new File("/home/juninhsilva14/Documents/SI/cursos/curso-dio-io-java/recomendacoes.txt");
        String nome = file.getName();

        Reader reader = new FileReader(nome);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        String nomeCopia = nome.substring(0, nome.indexOf(".")).concat("-copia.txt");
        File copia = new File(nomeCopia);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(copia.getName()));

        do{
            assert line != null;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            line = bufferedReader.readLine();
        }while (line == null);

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.printf("Arquivo \"%s\" foi criado com sucesso! \nTamanho: \"%d\" bytes\n", copia.getName(), copia.length());

        printWriter.printf("Insira 3 livros: ");
        printWriter.flush();

        adicionarInfo(copia.getName());

        printWriter.close();
        printWriter.printf("Informações adicionadas ao arquivo \"%s\" com sucesso! \nTamanho: \"%d\" bytes", copia.getName(), copia.length());

        bufferedWriter.close();
        reader.close();
    }

    public static void adicionarInfo(String arquivo) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        String line = bufferedReader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo , true));
        do {
            bufferedWriter.write(line);;
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        }while (!line.equalsIgnoreCase("fim"));
    }

    public static void copiarArquivoBytes() throws IOException {
        File file = new File("/home/juninhsilva14/Documents/SI/cursos/curso-dio-io-java/recomendacoes-copia.txt");
        String nomeArquivo = file.getName();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(nomeArquivo));

        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copia-2.txt");
        File arquivoCopia = new File(nomeArquivoCopia);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(arquivoCopia));

        int line = 0;
        while((line = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(line);
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

        PrintStream printStream = new PrintStream(System.out);
        printStream.printf("Arquivo \"%s\" foi copiado com sucesso! \nTamanho: \"%d\" bytes\n", arquivoCopia.getName(), arquivoCopia.length());
    }

    public static void main(String[] args) throws IOException {
        //tecladoConsole();
        //escreverDocumento();
        //copiarArquivo();
        copiarArquivoBytes();
    }


}

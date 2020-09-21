public class Main {

    public static void main(String[] args) {

        int termo = 10_000;
        int lowerBound = termo-3;

        /*
        System.out.println("---- Fibonacci recursivo ----");
        System.out.println("---- Tempo de execução exponencial O(2^n) ----");
        for (int i = lowerBound; i <= termo; i++) {
            System.out.println("Termo " + i + " é: " + fibonacciRecursivo(i));
        }

         */

        System.out.println("");
        System.out.println("---- Fibonacci por Programação Dinâmica ----");
        System.out.println("---- Tempo de execução polinomial O(n) ----");
        for (int i = lowerBound; i <= termo; i++) {
            System.out.println("Termo " + i + " é: " + fibonacciMemoized(i));
        }

        System.out.println("");
        System.out.println("---- Fibonacci por Programação Dinâmica Bottom Up ----");
        System.out.println("---- Tempo de execução polinomial O(n) ----");
        for (int i = lowerBound; i <= termo; i++) {
            System.out.println("Termo " + i + " é: " + fibonacciDPBottomUP(i));
        }
    }

    //tempo de execução exponencial
    public static int fibonacciRecursivo (int termo){
        int f;
        if (termo<=2) {
            f=1;
            return 1;}
        else f=fibonacciRecursivo(termo-1) + fibonacciRecursivo(termo -2);
        return f;
    }

    //Esse é o método chamado, pois precisamos criar o vetor antes
    public static int fibonacciMemoized (int termo){
        int[] memo = new int[termo+1];
        for (int i=0; i<=termo; i++){
            memo[i] = -1;
        }
        return fibonacciDP(memo, termo);
    }

    public static int fibonacciDP(int [] memo, int termo){
        int f;

        //essa linha é da Programação Dinâmica
        if (memo[termo-1]!=-1) return memo[termo-1];

        //as linhas abaixo são as mesmas do fibonacci recursivo
        if (termo<=2) {
            f=1;
            return 1;
        }

        else f=fibonacciDP(memo, termo-1) + fibonacciDP(memo, termo -2);

        //essa linha é da Programação Dinâmica
        memo[termo-1]=f;

        return f;
    }

    public static int fibonacciDPBottomUP (int termo){
        int [] memo = new int[termo+1];

        memo[0]=0;
        memo[1]=1;
        memo[2]=1;

        for (int i=2; i<=termo;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[termo];
    }
}

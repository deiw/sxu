public class Main {
    public static void main(String[] args) {
        //AND
        double andBias = -1.5;
        double andX1 = 1;
        double andX2 = 0;
        double andX1Weight = 1;
        double andX2Weight = 1;
        int andOutput = activationFunction(andBias + andX1 * andX1Weight + andX2 * andX2Weight);

        //OR
        double orBias = -0.5;
        double orX1 = 0;
        double orX2 = 0;
        double orX1Weight = 1;
        double orX2Weight = 1;
        int orOutput = activationFunction(orBias + orX1 * orX1Weight + orX2 * orX2Weight);

        //NOT
        double notBias = 1;
        double notX1 = 1;
        double notX1Weight = -2;
        int notOutput = activationFunction(notBias + notX1 * notX1Weight);

        System.out.println("AND, OR, NOT");
        System.out.println("| GATE | X1  | X2  | X1 WEIGHT | X2 WEIGHT | BIAS | X1 * WEIGHT | X2 * WEIGHT | OUTPUT |");
        System.out.println(String.format("| %s  | %s | %s | %s       | %s       | %s | %s         | %s         | %s      |", "AND", andX1, andX2, andX1Weight, andX2Weight, andBias, andX1 * andX1Weight, andX2 * andX2Weight, andOutput));
        System.out.println(String.format("| %s   | %s | %s | %s       | %s       | %s | %s         | %s         | %s      |", "OR", orX1, orX2, orX1Weight, orX2Weight, orBias, orX1 * orX1Weight, orX2 * orX2Weight, orOutput));
        System.out.println(String.format("| %s  | %s | %s | %s      | %s       | %s  | %s        | %s         | %s      |", "NOT", notX1, "N/A", notX1Weight, "N/A", notBias, notX1 * notX1Weight, "N/A", notOutput));
        System.out.println();

        //XNOR && XOR
        int xnorX1 = 0;
        int xnorX2 = 0;

        double firstNeuronOutput = activationFunction(0.5 - xnorX1 - xnorX2);
        double secondNeuronOutput = activationFunction(-1.5 + xnorX1 + xnorX2);
        double thirdNeuronOutput = activationFunction(-0.5 + firstNeuronOutput + secondNeuronOutput);
        double fourthNeuronOutput = activationFunction(1 + thirdNeuronOutput * -2);

        System.out.println("XNOR && XOR");
        System.out.println("| NEURON   | X1  | X2  | X1 WEIGHT | X2 WEIGHT | BIAS | X1 * WEIGHT | X2 * WEIGHT | OUTPUT |");
        System.out.println(String.format("| %s        | %s   | %s   | %s        | %s        | %s  | %s           | %s           | %s    |", "1", xnorX1, xnorX2, -1, -1, 0.5, 0, 0, firstNeuronOutput));
        System.out.println(String.format("| %s        | %s   | %s   | %s         | %s         | %s | %s           | %s           | %s    |", "2", xnorX1, xnorX2, 1, 1, -1.5, 0, 0, secondNeuronOutput));
        System.out.println(String.format("| %s | %s   | %s   | %s         | %s         | %s | %s           | %s           | %s    |", "3 - XNOR", xnorX1, xnorX2, 1, 1, -0.5, 0, 0, thirdNeuronOutput));
        System.out.println(String.format("| %s  | %s | %s | %s        | %s       | %s    | %s          | %s         | %s    |", "4 - XOR", thirdNeuronOutput, "N/A", -2, "N/A", 1, -2, "N/A", fourthNeuronOutput));
    }

    private static int activationFunction(double value) {
        return value < 0 ? 0 : 1;
    }

}

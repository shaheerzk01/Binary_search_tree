package PROGRAMS;

import java.util.*;

public class MorseCodeDictionary {
    MorseCodeNode root;
    Map<String, String> alpha_dictionary  = new HashMap<String, String>() {{
        put("a", ".-");
        put("b", "-...");
        put("c", "-.-.");
        put("d", "-..");
        put("e", ".");
        put("f", "..-.");
        put("g", "--.");
        put("h", "....");
        put("i", "..");
        put("j", ".---");
        put("k", "-.-");
        put("l", ".-..");
        put("m", "--");
        put("n", "-.");
        put("o", "---");
        put("p", ".--.");
        put("q", "--.-");
        put("r", ".-.");
        put("s", "...");
        put("t", "-");
        put("u", "..-");
        put("v", "...-");
        put("w", ".--");
        put("x", "-..-");
        put("y", "-.--");
        put("z", "--..");
    }};


    public class MorseCodeNode {
        private String letter;
        private MorseCodeNode dot;
        private MorseCodeNode dash;

        public MorseCodeNode() {
            letter = null;
            dot = null;
            dash = null;
        }
        public String getLetter() {
            return letter;
        }
        public void setLetter(String l) {
            letter = l;
        }

        public MorseCodeNode getDot() {
            return dot;
        }
        public void setDot(MorseCodeNode n) {
            dot = n;
        }

        public MorseCodeNode getDash() {
            return dash;
        }
        public void setDash(MorseCodeNode n) {
            dash = n;
        }
        public String toString() {
            return
                    ((letter == null) ? "nul" : " " + letter + " ") + " " +
                    "@(" + Integer.toHexString(this.hashCode()) + ") " +
                    ".(" + ((dot == null) ? "null" : Integer.toHexString(dot.hashCode())) + ") " +
                    "-(" + ((dash == null) ? "null" : Integer.toHexString(dash.hashCode())) + ")";
        }

        public void toStringBuffer(StringBuffer s) {
            /*
            Print out to graphviz / TD format / mermaid markdown
             */
            String h = "  " + Integer.toHexString(this.hashCode());
            s.append(
                    h + ((letter == null) ? "( )" : "(" + letter + ")") + "\n"
            );
            if(getDot() != null) {
                s.append(h + " -->|.| " +
                    Integer.toHexString(getDot().hashCode()) + "\n"
                );
            }
            if(getDash() != null) {
                s.append(h + " -->|-| " +
                        Integer.toHexString(getDash().hashCode()) + "\n"
                );
            }
            if(getDot() != null) { getDot().toStringBuffer(s); }
            if(getDash() != null) { getDash().toStringBuffer(s); }
        }
    }

    public MorseCodeDictionary () {
        root = new MorseCodeNode();
        Iterator i = alpha_dictionary.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String,String> x = (Map.Entry<String,String>)i.next();
            System.out.println("adding '" + x.getKey() + "' - '"+x.getValue() + "'");
            add(x.getKey(), x.getValue());
        }
    }
    
    private void initializeNodes() {
    }
    
    private void add(String character, String signal) {
        MorseCodeNode current = root;
        for (int i = 0; i < signal.length(); i++) {
            String c = signal.substring(i, i+1);

            if (c.equals(".")) {
                if (current.getDot() == null) {
                    current.setDot(new MorseCodeNode());
                }
                current = current.getDot();
            } else if (c.equals("-")) {
                if (current.getDash() == null) {
                    current.setDash(new MorseCodeNode());
                }
                current = current.getDash();
            } else {
                System.out.println("Error - unknown character '" + c + "' encountered");
                return;
            }
        }
        current.setLetter(character);
    }



    public static void main(String[] args) {
        MorseCodeDictionary mcd = new MorseCodeDictionary();
        MorseCodeNode m;

        ArrayList<String> teststrings = new ArrayList<String>(Arrays.asList(
                ".-",
                ".",
                "..",
                "...",
                "....",
                ".....",
                "-----",
                "......"
        ));

      
    }
}


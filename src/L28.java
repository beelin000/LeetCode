class L28 {
    public int strStr(String h, String e) {
        if(h == null || e == null) {
            return -1;
        }
        if(e.length() == 0 ) {
            return 0;
        }
        if(h.length() < e.length()) {
            return -1;
        }

        a:for(int i=0; i<h.length(); i++){
            if(i+e.length() > h.length()) {
                return -1;
            }
            if(h.charAt(i) == e.charAt(0)) {
                b:for(int j=0; i+j<h.length() && j<e.length(); j++) {
                    if(h.charAt(i+j) != e.charAt(j)) {
                        continue a;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    private int strStr2( String h, String e) {
        if(h == null || e == null) {
            return -1;
        }
        if(e.length() == 0 ) {
            return 0;
        }
        if(h.length() < e.length()) {
            return -1;
        }

        return 0;
    }
}

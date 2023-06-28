package lmz.algorithm.other.easy.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> siteMap = new HashMap();
        for (String cp : cpdomains) {
            int cnt = 0;
            int idx = 0;
            while (idx < cp.length() && Character.isDigit(cp.charAt(idx))) {
                cnt = cnt * 10 + cp.charAt(idx++) - '0';
            }
            String[] split = cp.substring(idx+1).split("\\.");
            StringBuilder site = new StringBuilder();
            site.append(split[split.length - 1]);
            siteMap.put(site.toString(), siteMap.getOrDefault(site.toString(), 0) + cnt);
            for (int i = split.length - 2; i >= 0; i--) {
                //site.append(".").append(split[i]);
                site.insert(0, split[i] + ".");
                siteMap.put(site.toString(), siteMap.getOrDefault(site.toString(), 0) + cnt);
            }
        }
        List<String> res = new ArrayList<>(siteMap.size());
        for (var entry : siteMap.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}

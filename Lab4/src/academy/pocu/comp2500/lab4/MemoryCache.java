package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class MemoryCache {
    private static MemoryCache instance;
    private static ArrayList<MemoryCache> instances = new ArrayList<>();
    private static ArrayList<MemoryCache> lastUsedInstances = new ArrayList<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;

    private String hardDiskName;
    private int maxEntryCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private ArrayList<HashMap<String, String>> entrys = new ArrayList<>();
    private ArrayList<HashMap<String, String>> lastUsedEntrys = new ArrayList<>();

    private MemoryCache(String hardDiskName) {
        this.hardDiskName = hardDiskName;
        instances.add(this);
        lastUsedInstances.add(this);
    }

    public static MemoryCache getInstance(String hardDisk) {
        for (MemoryCache instance : instances) {
            if (instance.getHardDiskName().equals(hardDisk)) {
                instance.lastUsedTimeUpdate();
                return instance;
            }
        }

        MemoryCache.eviction();
        return instance = new MemoryCache(hardDisk);
    }

    public static void clear() {
        for (MemoryCache instance : instances) {
            instance = null;
            // null is enough? remove from instances? remove hardDiskName?
        }
        instances.clear();
        lastUsedInstances.clear();
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        MemoryCache.maxInstanceCount = maxInstanceCount;
        int dif = instances.size() - MemoryCache.maxInstanceCount;

        if (dif > 0) {
            for (int i = 0; i < dif; i++) {
                MemoryCache.eviction();
            }
        }
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
        lastUsedTimeUpdate();
    }

    public void addEntry(String key, String value) {
        HashMap<String, String> entry = new HashMap<>();
        entry.put(key, value);

        boolean isExist = false;

        for (HashMap<String, String> e : entrys) {
            if (e.keySet().contains(key)) {
                e.put(key, value);
                lastUsedTimeUpdate(e);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            eviction(this);
            entrys.add(entry);
            lastUsedEntrys.add(entry);
        }
    }

    public String getEntryOrNull(String entryKey) {
        for (HashMap<String, String> entry : entrys) {
            if (entry.get(entryKey) != null) {
                lastUsedTimeUpdate(entry);
                return entry.get(entryKey);
            }
        }
        return null;
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        int dif = entrys.size() - maxEntryCount;

        for (int i = 0; i < dif; i++) {
            eviction(this);
        }
    }

    private void eviction(MemoryCache instance) {
        skip_eviction:
        {
            if (entrys.size() < maxEntryCount) {
                break skip_eviction;
            }

            HashMap<String, String> entry = new HashMap<>();

            switch (instance.evictionPolicy) {
                case FIRST_IN_FIRST_OUT:
                    entry = entrys.get(0);
                    break;
                case LAST_IN_FIRST_OUT:
                    entry = entrys.get(entrys.size() - 1);
                    break;
                case LEAST_RECENTLY_USED:
                    entry = lastUsedEntrys.get(0);
                    break;
                default :
                    assert (false) : "Invalid eviction Policy";
                    break;
            }

            lastUsedEntrys.remove(entry);
            entrys.remove(entry);
            entry = null;
        }
    }

    private static void eviction() {
        if (instances.size() < maxInstanceCount) {
        } else {
            MemoryCache instance = lastUsedInstances.get(0);
            lastUsedInstances.remove(0);
            instances.remove(instance);
            instance = null;
        }
    }

    public String getHardDiskName() {
        return hardDiskName;
    }

    private void lastUsedTimeUpdate() {
        lastUsedInstances.remove(this);
        lastUsedInstances.add(this);
    }

    private void lastUsedTimeUpdate(HashMap<String, String> entry) {
        lastUsedEntrys.remove(entry);
        lastUsedEntrys.add(entry);
    }
}

package masa.java.homework.advanced.blobs;

import java.util.*;

public class BlobsApp {
    public static void main(String[] args) {
        List<Map<String,Integer>> generation0 = Arrays.asList(
                new HashMap<>() {{ put("x", 0); put("y", 4); put("size", 3); }},
                new HashMap<>() {{ put("x", 0); put("y", 7); put("size", 5); }},
                new HashMap<>() {{ put("x", 2); put("y", 0); put("size", 2); }},
                new HashMap<>() {{ put("x", 3); put("y", 7); put("size", 2); }},
                new HashMap<>() {{ put("x", 4); put("y", 3); put("size", 4); }},
                new HashMap<>() {{ put("x", 5); put("y", 6); put("size", 2); }},
                new HashMap<>() {{ put("x", 6); put("y", 7); put("size", 1); }},
                new HashMap<>() {{ put("x", 7); put("y", 0); put("size", 3); }},
                new HashMap<>() {{ put("x", 7); put("y", 2); put("size", 1); }}
        );
        Blobservation blobs = new Blobservation(8);
        blobs.populate(generation0);
        blobs.move();
        blobs.printState(); // [[0,6,5],[1,5,3],[3,1,2],[4,7,2],[5,2,4],[6,7,3],[7,1,3],[7,2,1]]
        blobs.move();
        blobs.printState(); // [[1,5,5],[2,6,3],[4,2,2],[5,6,2],[5,7,3],[6,1,4],[7,2,4]]
        blobs.move(1000);
        blobs.printState(); // [[4,3,23]]
    }
}
class Blobservation {
    int height;
    int width;
    int[][] blobsField;
    Blobservation (int h){
        this(h,h);
    }
    Blobservation (int h, int w){
        this.height = h; // maybe delete
        this.width =w; // maybe delete
        blobsField = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(blobsField[i],0);
        }
    }
    void populate(List<Map<String,Integer>> newBlobs) {
        if (!checkBlobs(newBlobs)) throw new Error();
        for (Map<String,Integer> blob: newBlobs) {
            int x = blob.get("x");
            int y = blob.get("y");
            int size = blob.get("size");
            blobsField[x][y] += size;
        }
    }

    void rePopulate(List<Map<String,Integer>> newBlobs) {
        blobsField = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(blobsField[i],0);
        }
        for (Map<String,Integer> blob: newBlobs) {
            int x = blob.get("x");
            int y = blob.get("y");
            int size = blob.get("size");
            blobsField[x][y] += size;
        }
    }

    void move() {
        List<Map<String,Integer>> newBlobs = new ArrayList<>();
        List<Map<String,Integer>> aimBlobs = new ArrayList<>();
        List<List<Integer>> myBlobs = getMyBlobs(); // take each blob from blobsField
        for (List<Integer> myNextBlob : myBlobs) { // find all blobs less than taken and add to aimBlobs list
            for (List<Integer> otherNextBlob : myBlobs) {
                if (otherNextBlob.get(2).compareTo(myNextBlob.get(2))<0) {
                    aimBlobs.add(getBlob(otherNextBlob.get(0),otherNextBlob.get(1),otherNextBlob.get(2))); //x, y, size
                }
            }
            // if there is no blobs less than taken add actual point and blob size to list of next tern population
            if(aimBlobs.size()==0) {
                newBlobs.add(getBlob(myNextBlob.get(0),myNextBlob.get(1),myNextBlob.get(2))); //x, y, size
                aimBlobs = new ArrayList<>();
                continue;
            }
            // if there is only one blob less than taken -
            // count x and y of new blob after one turn, add this blob to list of next tern population
            if (aimBlobs.size()==1){
                int direction = getDirection(myNextBlob,aimBlobs.get(0));
                newBlobs.add(getBlob(myNextBlob.get(0),myNextBlob.get(1),myNextBlob.get(2),direction));
                aimBlobs = new ArrayList<>();
                continue;
            }
            // if there are few blobs less than taken find nearest of them
            if (aimBlobs.size()>1) {
                int minDistance = Math.max(height,width)+1;
                int numberOfMinDisBlobs = 0;
                for (Map<String,Integer> nextAimBlob : aimBlobs) {
                    int dX = Math.abs(nextAimBlob.get("x") - myNextBlob.get(0));
                    int dY = Math.abs(nextAimBlob.get("y") - myNextBlob.get(1));
                    int distance = Math.max(dX,dY);
                    if (distance < minDistance) {
                        minDistance = distance;
                        numberOfMinDisBlobs = 1;
                    } else if (distance == minDistance) numberOfMinDisBlobs++;
                }
                // if there is one nearest blob - find it in aimBlobs, then -
                // count x and y of new blob after one turn, add this blob to list of next tern population
                if (numberOfMinDisBlobs == 1){
                    for (Map<String,Integer> nextAimBlob : aimBlobs) {
                        int dX = Math.abs(nextAimBlob.get("x") - myNextBlob.get(0));
                        int dY = Math.abs(nextAimBlob.get("y") - myNextBlob.get(1));
                        int distance = Math.max(dX,dY);
                        if (distance == minDistance) {
                            int direction = getDirection(myNextBlob,nextAimBlob);
                            newBlobs.add(getBlob(myNextBlob.get(0),myNextBlob.get(1),myNextBlob.get(2),direction));
                            aimBlobs = new ArrayList<>();
                            break;
                        }
                    }
                    continue;
                }
                // if there are few nearest blobs - remove every blob, that is not the nearest from aimBlobs list
                if (numberOfMinDisBlobs > 1) {
                    Iterator<Map<String,Integer>> aimBlobsIterator = aimBlobs.iterator();
                    while (aimBlobsIterator.hasNext()){
                        Map<String,Integer> nextAimBlob = aimBlobsIterator.next();
                        int dX = Math.abs(nextAimBlob.get("x") - myNextBlob.get(0));
                        int dY = Math.abs(nextAimBlob.get("y") - myNextBlob.get(1));
                        int distance = Math.max(dX,dY);
                        if (distance > minDistance) {
                            aimBlobsIterator.remove();
                        }
                    }
                    // now find biggest of blobs, that left
                    int biggestSize = 0;
                    int numberOfBiggestBlobs = 0;
                    for (Map<String,Integer> nextAimBlob : aimBlobs) {
                        int size = nextAimBlob.get("size");
                        if (size > biggestSize) {
                            biggestSize = size;
                            numberOfBiggestBlobs = 1;
                            continue;
                        }
                        if (size == biggestSize) numberOfBiggestBlobs++;
                    }
                    // if there is one biggest left
                    // count x and y of new blob after one turn, add this blob to list of next tern population
                    if(numberOfBiggestBlobs == 1) {
                        for (Map<String,Integer> nextAimBlob : aimBlobs) {
                            int size = nextAimBlob.get("size");
                            if (size == biggestSize) {
                                int direction = getDirection(myNextBlob,nextAimBlob);
                                newBlobs.add(getBlob(myNextBlob.get(0),myNextBlob.get(1),myNextBlob.get(2),direction));
                                aimBlobs = new ArrayList<>();
                                break;
                            }
                        }
                        continue;
                    }
                    // if there are few biggest blobs - remove every blob, that is not the biggest from aimBlobs list
                    if (numberOfBiggestBlobs > 1) {
                        aimBlobsIterator = aimBlobs.iterator();
                        while (aimBlobsIterator.hasNext()){
                            Map<String,Integer> nextAimBlob = aimBlobsIterator.next();
                            int size = nextAimBlob.get("size");
                            if (size < biggestSize) {
                                aimBlobsIterator.remove();
                            }
                        }
                        // find one with priority of clockwise rotation, starting from the 12 position
                        int maxPriorityDirection = 8;
                        for (Map<String,Integer> nextAimBlob : aimBlobs) {
                            int direction = getDirection(myNextBlob,nextAimBlob);
                            if (direction<maxPriorityDirection) maxPriorityDirection = direction;
                        }
                        for (Map<String,Integer> nextAimBlob : aimBlobs) {
                            int direction = getDirection(myNextBlob,nextAimBlob);
                            if (direction == maxPriorityDirection) {
                                newBlobs.add(getBlob(myNextBlob.get(0),myNextBlob.get(1),myNextBlob.get(2),direction));
                                aimBlobs = new ArrayList<>();
                                break;
                            }
                        }
                    }
                }
            }
        }
        rePopulate(newBlobs);
    }

    void move(int nTimes) {
        for (int i = 0; i < nTimes; i++) {
            move();
        }
    }

    int getDirection(List<Integer> pointA, Map<String,Integer> pointB) {
        int dX = pointB.get("x") - pointA.get(0);
        int dY = pointB.get("y") - pointA.get(1);
        if(dX < 0){
            if(dY<0) {
                return 7;
            }
            if(dY==0) {
                return 0;
            }
            if(dY>0) {
                return 1;
            }
        }
        if(dX == 0) {
            if(dY<0) {
                return 6;
            }
            if(dY>0) {
                return 2;
            }
            if(dY == 0){
                return 8;
            }
        }
        if (dX > 0) {
            if (dY < 0) {
                return 5;
            }
            if (dY == 0) {
                return 4;
            }
            if (dY > 0) {
                return 3;
            }
        }
        return 8;
    }

    List<List<Integer>> getMyBlobs() {
        List<List<Integer>> myBlobs = new ArrayList<>();
        for (int i = 0; i < height; i++) { // take each blob from blobsField
            for (int j = 0; j < width; j++) {
                if(blobsField[i][j]!=0) {
                    List<Integer> nextBlob = new ArrayList<>();
                    nextBlob.add(i);
                    nextBlob.add(j);
                    nextBlob.add(blobsField[i][j]);
                    myBlobs.add(nextBlob);
                }
            }
        }
        return myBlobs;
    }

    List<List<Integer>> printState() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(blobsField[i][j]!=0) {
                    List<Integer> tmpList = new ArrayList<>(3);
                    tmpList.add(i);
                    tmpList.add(j);
                    tmpList.add(blobsField[i][j]);
                    System.out.print(tmpList + " ");
                    result.add(tmpList);
                }
            }
        }
        System.out.println();
        return result;
    }

    boolean checkBlobs(List<Map<String,Integer>> blobs) {
        if (blobs == null|| blobs.isEmpty()) {
            return false;
        }
        for (Map<String,Integer> map: blobs) {
            if (map == null || map.isEmpty()) {
                return false;
            }

            if(!map.containsKey("x")) { //check X
                return false;
            } else if (map.get("x").compareTo(height)>=0) {
                return false;
            }

            if(!map.containsKey("y")){ //check Y
                return false;
            } else if (map.get("y").compareTo(width)>=0) {
                return false;
            }

            if(!map.containsKey("size")){ //check size
                return false;
            } else if ( map.get("size").compareTo(20)>0) { //problem
                return false;
            } else if ( map.get("size").compareTo(1)<0) {
                return false;
            }

            if(map.size()!=3){ //check number of args
                return false;
            }
        }
        return true;
    }

    Map<String,Integer> getBlob (int x, int y, int size) {
        return getBlob(x,y,size,8);
    }

    Map<String,Integer> getBlob (int x, int y, int size, int direction) {
        Map<String,Integer> blobResult = new HashMap<>();
        switch (direction){
            case 8:
                blobResult.put("x",x);
                blobResult.put("y",y);
                blobResult.put("size",size);
                break;
            case 7:
                blobResult.put("x",x-1);
                blobResult.put("y",y-1);
                blobResult.put("size",size);
                break;
            case 6:
                blobResult.put("x",x);
                blobResult.put("y",y-1);
                blobResult.put("size",size);
                break;
            case 5:
                blobResult.put("x",x+1);
                blobResult.put("y",y-1);
                blobResult.put("size",size);
                break;
            case 4:
                blobResult.put("x",x+1);
                blobResult.put("y",y);
                blobResult.put("size",size);
                break;
            case 3:
                blobResult.put("x",x+1);
                blobResult.put("y",y+1);
                blobResult.put("size",size);
                break;
            case 2:
                blobResult.put("x",x);
                blobResult.put("y",y+1);
                blobResult.put("size",size);
                break;
            case 1:
                blobResult.put("x",x-1);
                blobResult.put("y",y+1);
                blobResult.put("size",size);
                break;
            case 0:
                blobResult.put("x",x-1);
                blobResult.put("y",y);
                blobResult.put("size",size);
                break;
            default:
                throw new RuntimeException();
        }
        return blobResult;
    }
}

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Finder {

    public static String findViewPoints(JSONObject jsonObject, int n){
        JSONArray elements = jsonObject.getJSONArray("elements");
        JSONArray values = jsonObject.getJSONArray("values");

        JSONArray nodes = jsonObject.getJSONArray("nodes");
        Node[] vertices = new Node[nodes.length()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Node();
        }
        for (int i = 0; i < elements.length(); i++) {
            JSONArray nodeIndices = elements.getJSONObject(i).getJSONArray("nodes");
            for (int j = 0; j < nodeIndices.length(); j++) {
                vertices[nodeIndices.getInt(j)].addIndex(elements.getJSONObject(i).getInt("id"));
            }
        }

        Element[] elementArray = new Element[elements.length()];
        for(int i = 0; i < elements.length(); i++){
            JSONObject currentElement = elements.getJSONObject(i);
            JSONObject currentHeightValue = values.getJSONObject(i);
            elementArray[i] = new Element(currentHeightValue.getFloat("value"), currentElement.getInt("id"));
        }

        List<ViewSpot> spots = new ArrayList<>();
        for (int i = 0; i < elements.length(); i++) {
            if(spots.size() >= n){
                break;
            }
            boolean isViewSpot = true;
            if(elementArray[i] != null){
                List<Integer> neighbors = getNeighborsOfElement(elementArray[i].getId(), elements, vertices);
                for (Integer neighbor : neighbors) {

                    if(elementArray[neighbor].isViewSpot() && elementArray[neighbor].getHeight() == elementArray[i].getHeight()){
                        elementArray[i].setViewSpot(true);
                        isViewSpot = false;
                        break;
                    }
                    if (!(elementArray[neighbor].getHeight() <= elementArray[i].getHeight())) {
                        isViewSpot = false;
                        break;
                    }
                }

                if (isViewSpot) {
                    spots.add(new ViewSpot(elementArray[i].getId(), elementArray[i].getHeight()));
                    elementArray[i].setViewSpot(true);
                }
            }
        }

        spots.sort(Comparator.comparingDouble(ViewSpot::getHeight).reversed());
        System.out.println(writeViewSpots(spots));
        return writeViewSpots(spots);
    }

    private static List<Integer> getNeighborsOfElement(int elementId, JSONArray elements, Node[] vertices){
        List<Integer> neighbors = new ArrayList<>();

        JSONArray nodes = elements.getJSONObject(elementId).getJSONArray("nodes");

        for (int i = 0; i < nodes.length(); i++) {
            neighbors.addAll(vertices[nodes.getInt(i)].getElementIndices());
        }

        neighbors = neighbors.stream().distinct().collect(Collectors.toList());
        neighbors.remove(Integer.valueOf(elementId));

        return neighbors;
    }

    public static String writeViewSpots(List<ViewSpot> viewSpots){
        StringBuilder s = new StringBuilder("[\n");
        for (int i = 0; i < viewSpots.size(); i++) {
            s.append("  {element_id: ").append(viewSpots.get(i).getElementId()).append(", value: ").append(viewSpots.get(i).getHeight()).append("}");

            if(i != viewSpots.size() - 1){
                s.append(",");
            }
            s.append("\n");
        }
        s.append("]");

        return s.toString();
    }
}

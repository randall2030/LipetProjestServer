package com.envcheck.android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 2016/5/22.
 */
public class SceneCollectTask implements Serializable {

    private SceneCollectPhotoTask sceneCollectPhotoTask;
    private List<SceneCollectModuleTask> sceneCollectModuleTasks = new ArrayList<>();

    public SceneCollectPhotoTask getSceneCollectPhotoTask() {
        return sceneCollectPhotoTask;
    }

    public void setSceneCollectPhotoTask(SceneCollectPhotoTask sceneCollectPhotoTask) {
        this.sceneCollectPhotoTask = sceneCollectPhotoTask;
    }

    public List<SceneCollectModuleTask> getSceneCollectModuleTasks() {
        return sceneCollectModuleTasks;
    }

    public void setSceneCollectModuleTasks(List<SceneCollectModuleTask> sceneCollectModuleTasks) {
        this.sceneCollectModuleTasks = sceneCollectModuleTasks;
    }
}

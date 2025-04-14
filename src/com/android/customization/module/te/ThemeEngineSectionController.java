/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.customization.module.te;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.android.wallpaper.model.CustomizationSectionController;

import com.android.themepicker.R;

import java.util.List;


/** A {@link CustomizationSectionController} for system Themes. */

public class ThemeEngineSectionController implements CustomizationSectionController<ThemeEngineSectionView> {

    private static final String TAG = "ThemeEngineSectionController";

    public ThemeEngineSectionController() {}

    @Override
    public boolean isAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("io.github.dot166.themeengine.CONFIG");
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return !list.isEmpty();
    }

    @Override
    public ThemeEngineSectionView createView(Context context) {
        ThemeEngineSectionView ThemeEngineSectionView = (ThemeEngineSectionView) LayoutInflater.from(context)
                .inflate(R.layout.te_section_view, /* root= */ null);

        ((ImageView) ThemeEngineSectionView.findViewById(R.id.te_section_tile)).setImageDrawable(context.getResources().getDrawable(io.github.dot166.jlib.R.mipmap.ic_themeengine));

        ThemeEngineSectionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent("io.github.dot166.themeengine.CONFIG"));
            }
        });

        return ThemeEngineSectionView;
    }

    @Override
    public boolean shouldRetainInstanceWhenSwitchingTabs() {
        return false;
    }

    @NonNull
    @Override
    public ThemeEngineSectionView createView(@NonNull Context context, @NonNull ViewCreationParams params) {
        return createView(context);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
    }

    @Override
    public void release() {
    }

    @Override
    public void onTransitionOut() {
    }
}
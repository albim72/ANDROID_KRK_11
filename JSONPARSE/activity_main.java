<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <Button
            android:id="@+id/btnParsuj"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="parsuj źródło JSON" />

        <TextView
            android:id="@+id/wynik"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

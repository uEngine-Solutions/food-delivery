<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="markDeliveryCompletedDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Rider')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>배달 완료 처리하기
                </v-btn>
                <v-dialog v-model="markDeliveryCompletedDialog" width="500">
                    <MarkDeliveryCompleted
                        @closeDialog="markDeliveryCompletedDialog = false"
                        @markDeliveryCompleted="markDeliveryCompleted"
                    ></MarkDeliveryCompleted>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>이름</th>
                        <th>라이더 상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="이름">{{ val.riderName }}</td>
                            <td class="whitespace-nowrap" label="라이더 상태">{{ val.riderStatus }}</td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Rider 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Rider :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Rider 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="라이더 ID" v-model="selectedRow.riderId" :editMode="true"/>
                            <String label="이름" v-model="selectedRow.riderName" :editMode="true"/>
                            <String label="라이더 상태" v-model="selectedRow.riderStatus" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'
import Rider from '../Rider.vue'
import String from '../primitives/String.vue'
import MarkDeliveryCompleted from '../MarkDeliveryCompleted.vue'

export default {
    name: 'riderGrid',
    mixins:[BaseGrid],
    components:{
        Rider,
        String,
        MarkDeliveryCompleted,
    },
    data: () => ({
        path: 'riders',
        markDeliveryCompletedDialog: false,
    }),
    watch: {
    },
    methods:{
        markDeliveryCompleted(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "markDeliveryCompleted", params)
                this.$EventBus.$emit('show-success','MarkDeliveryCompleted 성공적으로 처리되었습니다.')
                this.markDeliveryCompletedDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>
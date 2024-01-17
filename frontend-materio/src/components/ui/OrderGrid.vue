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
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>음식 선택</th>
                        <th>수량</th>
                        <th>특별 요청</th>
                        <th>배달 주소</th>
                        <th>결제 방법</th>
                        <th>결제 방법 유형</th>
                        <th>주문 금액</th>
                        <th>주문 상태</th>
                        <th>예상 배달 시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="음식 선택">{{ val.foodSelection }}</td>
                            <td class="whitespace-nowrap" label="수량">{{ val.quantity }}</td>
                            <td class="whitespace-nowrap" label="특별 요청">{{ val.specialRequest }}</td>
                            <td class="whitespace-nowrap" label="배달 주소">{{ val.deliveryAddress }}</td>
                            <td class="whitespace-nowrap" label="결제 방법">{{ val.paymentMethod }}</td>
                            <td class="whitespace-nowrap" label="결제 방법 유형">{{ val.paymentMethodType }}</td>
                            <td class="whitespace-nowrap" label="주문 금액">{{ val.orderAmount }}</td>
                            <td class="whitespace-nowrap" label="주문 상태">{{ val.orderStatus }}</td>
                            <td class="whitespace-nowrap" label="예상 배달 시간">{{ val.estimatedDeliveryTime }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Order 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Order :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Order 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="주문 ID" v-model="selectedRow.orderId" :editMode="true"/>
                            <String label="음식 선택" v-model="selectedRow.foodSelection" :editMode="true"/>
                            <Number label="수량" v-model="selectedRow.quantity" :editMode="true"/>
                            <String label="특별 요청" v-model="selectedRow.specialRequest" :editMode="true"/>
                            <String label="결제 방법" v-model="selectedRow.paymentMethod" :editMode="true"/>
                            <String label="주문 상태" v-model="selectedRow.orderStatus" :editMode="true"/>
                            <String label="예상 배달 시간" v-model="selectedRow.estimatedDeliveryTime" :editMode="true"/>
                            <paymentMethodType offline label="결제 방법 유형" v-model="selectedRow.paymentMethodType" :editMode="true"/>
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
import Order from '../Order.vue'
import String from '../primitives/String.vue'
import Number from '../primitives/Number.vue'
import paymentMethodType from '../paymentMethodType.vue'

export default {
    name: 'orderGrid',
    mixins:[BaseGrid],
    components:{
        Order,
        String,
        Number,
        paymentMethodType,
    },
    data: () => ({
        path: 'orders',
    }),
    watch: {
    },
    methods:{
    }
}

</script>